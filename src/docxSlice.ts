import { createSlice, PayloadAction } from "@reduxjs/toolkit"
import { RootState } from "./store"

interface DocxBlob {
    blob: Blob
}

interface DocxBlobState {
    blob: Blob
}

const encoder = new TextEncoder()

const initialDocx: DocxBlobState = {
    blob: new Blob([encoder.encode("")]),
}

const docxSlice = createSlice({
    name: "docx",
    initialState: initialDocx,
    reducers: {
        docxFetched: (state, action: PayloadAction<DocxBlob>) => {
            state.blob = action.payload.blob
        },
    },
})

export const { docxFetched } = docxSlice.actions
export const selectDocx = (state: RootState) => state.docx.blob
export default docxSlice.reducer
