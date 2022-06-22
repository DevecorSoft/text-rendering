import { render, screen } from "@testing-library/react"
import App from "./App"

describe("renders app", () => {
    render(<App />)

    it("should contains title: text-rendering", () => {
        const title = screen.getByText("text-rendering")
        expect(title).toBeInTheDocument()
    })

    it("should contains a plaintext editor container", () => {})
})
