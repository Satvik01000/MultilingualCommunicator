import React from 'react'
import Link from 'next/link'
import Image from 'next/image'
import { Button } from './ui/button'

const Header = () => {
  return (
   <nav className='mx-auto py-2 px-4 flex justify-between items-center shadow-md border-b-2'>
    <Link href="/" className="flex items-center">
        <Image
            src="/code1.png"
            width="150"
            height="50"
            alt="verseAI"
            className='h-10 w-auto'
        />   
    </Link>
    <div className='flex items-center gap-4'>
        <Button className="bg-green-600 text-white" variant="outline">Login</Button>
    </div>

   </nav>
  )
}

export default Header