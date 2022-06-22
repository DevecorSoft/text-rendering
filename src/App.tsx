import "./App.css"
import { Layout } from "antd"
import ForkMeOnGithub from "./components/fork-me-on-github/fork-me-on-github"

const { Header, Content } = Layout

function App() {
    return (
        <Layout>
            <ForkMeOnGithub />
            <Header style={{ display: "flex", justifyContent: "center" }}>
                <h1 style={{color: "#FFF"}}>text-rendering</h1>
            </Header>
            <Content>Content</Content>
        </Layout>
    )
}

export default App
