import { render, screen } from "@testing-library/react"
import ForkMeOnGithub from "./fork-me-on-github"

describe("renders fork me on github", () => {
    it("should contains link text that point github repository", () => {
        render(<ForkMeOnGithub />)
        const forkMeOnGithub = screen.getByAltText("Fork me on Github")
        expect(forkMeOnGithub).toBeInTheDocument()
        expect(forkMeOnGithub.tagName).toEqual("IMG")
        expect(forkMeOnGithub?.parentElement?.getAttribute("href")).toEqual(
            "https://github.com/DevecorSoft/text-rendering"
        )
    })
})
