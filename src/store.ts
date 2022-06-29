import { configureStore } from "@reduxjs/toolkit"
import docxReducer from "./docxSlice"

export const store = configureStore({
    reducer: {
        docx: docxReducer,
    },
})
export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
