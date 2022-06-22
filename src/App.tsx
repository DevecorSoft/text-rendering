import "./App.css"
import { Layout, Space } from "antd"
import ForkMeOnGithub from "./components/fork-me-on-github/fork-me-on-github"

const { Header, Content } = Layout

function App() {
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
                    <div className="ptr-container">editor container</div>
                    <div className="ptr-container">previewer container</div>
                    <div>menu area</div>
                </Space>
            </Content>
        </Layout>
    )
}

export default App
