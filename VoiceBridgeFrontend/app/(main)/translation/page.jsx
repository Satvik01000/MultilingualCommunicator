import { Button } from '@/components/ui/button';
import {
    DropdownMenu,
    DropdownMenuContent,
    DropdownMenuItem,
    DropdownMenuLabel,
    DropdownMenuSeparator,
    DropdownMenuTrigger,
  } from "@/components/ui/dropdown-menu"
  
import { Textarea } from '@/components/ui/textarea';
import { ArrowRight, Copy, EarIcon, EarOffIcon, Languages, LanguagesIcon, MailOpen, Mic, Mic2, ScanSearchIcon, Text, TextIcon } from 'lucide-react';
import Image from 'next/image';
import Link from 'next/link';
import React from 'react';

const Translation = () => {
  return (
      <div className='max-w mx-auto  p-4 bg-green-50 w-full sm:w-1/2  rounded-2xl transition-shadow duration-400  hover:shadow-[-7px_7px_0px_#50C878]'>
            <h1 className='text-2xl font-bold bg-gradient-to-br from-green-600 to-green-400 bg-clip-text tracking-tighter text-transparent pr-2 pb-6'>
                <div className='flex gap-5'>
                  <Image src="/code1.png" width="150" height="50" alt="verseAI" className='h-10 w-auto ml-2' />
                  <span className='text-4xl'>Translate</span>
                </div>
        
            </h1>
            <h1 className='text-2xl font-bold bg-gradient-to-br from-green-600 to-green-400 bg-clip-text tracking-tighter text-transparent pr-2 pb-6'> Choose your Translation Mode</h1>
            <div className='flex gap-10'>
              <Link href={"/audiotranslation"}>
                <Button size="lg"  variant="outline" className="bg-green-600 text-white rounded-lg p-5 text-center">
                    <Mic/>Audio
                </Button>
              </Link>
              <Link href={"/visualtranslation"}>
                <Button size="lg"  variant="outline" className="bg-green-600 text-white rounded-lg py-5 text-center">
                    <ScanSearchIcon/>Scan
                </Button>
              </Link>
              <Link href={"/texttranslation"}>
                <Button size="lg"  variant="outline" className="bg-green-600 text-white rounded-lg py-5 text-center">
                    <TextIcon/>Text
                </Button>
              </Link>
              <Link href={"/signtranslation"}>
                <Button size="lg"  variant="outline" className="bg-green-600 text-white rounded-lg py-5 text-center">
                    <EarOffIcon/>Sign
                </Button>
              </Link>

            </div>
      </div>
    
  );
};

export default Translation;