import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    host: true,
    strictPort: true,
    port: 5173,
    allowedHosts: [
      '5173-ekek54-mini5-m91faypwqoo.ws-us120.gitpod.io'  
    ],
  },
})

