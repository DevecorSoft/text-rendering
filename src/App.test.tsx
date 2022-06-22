import { render, screen } from "@testing-library/react"
import App from "./App"

describe("renders header", () => {
    it("should contains title: text-rendering", () => {
        render(<App />)
        const title = screen.getByText("text-rendering")
        expect(title).toBeInTheDocument()
    })
})
