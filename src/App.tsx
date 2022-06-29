import "./App.css"
import { Layout, Space, Button } from "antd"
import ForkMeOnGithub from "./components/fork-me-on-github/fork-me-on-github"
import Editor from "@monaco-editor/react"
import monaco from "monaco-editor/esm/vs/editor/editor.api"
import { useRef } from "react"
import axios from "axios"
import { useAppDispatch } from "./hooks"
import { docxFetched } from "./docxSlice"
import { renderAsync } from "docx-preview"

const { Header, Content } = Layout

function App() {
    const editorRef = useRef<monaco.editor.IStandaloneCodeEditor | null>(null)
    const dsipatch = useAppDispatch()

    function handleEditorDidMount(editor: monaco.editor.IStandaloneCodeEditor) {
        editorRef.current = editor
    }

    function render() {
        axios
            .post(
                "http://localhost:8080/rendering/markdown",
                {
                    content: editorRef.current?.getValue(),
                },
                { responseType: "arraybuffer" }
            )
            .then((response) => {
                renderAsync(
                    response.data,
                    document.getElementById("container")!
                ).then(() => {
                    console.log("docx: finished!")
                })
            })
            .catch((err) => {
                console.log(err)
            })
    }

    return (
        <Layout>
            <ForkMeOnGithub />
            <Header style={{ display: "flex", justifyContent: "center" }}>
                <h1 style={{ color: "#FFF" }}>text-rendering</h1>
            </Header>
            <Content
                style={{
                    marginTop: "85px",
                    display: "flex",
                    justifyContent: "center",
                }}
            >
                <Space align="start">
                    <div>language selector</div>
                    <div className="ptr-container">
                        <Editor
                            height="70vh"
                            defaultLanguage="markdown"
                            defaultValue={"# Title\ndescription\n"}
                            onMount={handleEditorDidMount}
                        />
                        <Button type="primary" onClick={render}>
                            Render
                        </Button>
                    </div>
                    <div className="ptr-container">
                        <div id="container">
                            previewer container placeholder
                        </div>
                    </div>
                    <div>menu area</div>
                </Space>
            </Content>
        </Layout>
    )
}

export default App
