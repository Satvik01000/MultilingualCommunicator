import { Inter } from "next/font/google";

const inter = Inter({ subsets: ["latin"] });

export default function AppLayout({ children }) {
  return (
    <div className={inter.className}>
     
      {children} 
    </div>
  );
}