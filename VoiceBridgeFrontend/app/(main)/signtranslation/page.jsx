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
import { ArrowRight, ChevronDown, Copy, EarOffIcon, FileText, GraduationCap, Languages, LanguagesIcon, MailOpen, Mic, PenBox, ScanSearchIcon, StarsIcon } from 'lucide-react';
import Image from 'next/image';
import Link from 'next/link';
import React from 'react';

const SignTranslation = () => {
  return (
    <div className='max-w mx-auto  p-4 bg-green-50 w-full sm:w-1/2  rounded-2xl transition-shadow duration-400  hover:shadow-[-7px_7px_0px_#50C878]'>
    <h1 className='text-2xl font-bold bg-gradient-to-br from-green-600 to-green-400 bg-clip-text tracking-tighter text-transparent pr-2 pb-6'>
        <div className='flex gap-5'>
          <Image src="/code1.png" width="150" height="50" alt="verseAI" className='h-10 w-auto ml-2' />
          <span className='text-4xl'>Sign Translation</span>
          <div className='ml-70'>
          <DropdownMenu >
            <DropdownMenuTrigger asChild>
                <Button size="lg"  variant="outline" className="bg-green-600 text-white rounded-lg p-5 text-center">
                  <StarsIcon className="h-4 w-4" />
                  <span className="hidden md:block">Other</span>
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
                    <DropdownMenuContent>
                        <DropdownMenuItem asChild>
                            <Link href={"/texttranslation"}>
                                Text
                            </Link>
                        </DropdownMenuItem>
                        <DropdownMenuItem asChild>
                            <Link href={"/scantranslation"}>
                                Scan
                            </Link>
                        </DropdownMenuItem>
                        <DropdownMenuItem asChild>
                            <Link href={"/audiotranslation"}>
                                Audio
                            </Link>
                        </DropdownMenuItem>
                      
                    </DropdownMenuContent>
                    
            </DropdownMenu>
          </div>

        </div>
        

    </h1>
  

        
        <form>
        {/* <div className="choices">
          <input
            type="radio"
            id="hindi"
            name="language"
            value="Hindi"

          />
          <label htmlFor="hindi">Hindi</label>

          <input
            type="radio"
            id="spanish"
            name="language"
            value="Spanish"
            
          />
          <label htmlFor="spanish">Spanish</label>

          <input
            type="radio"
            id="japanese"
            name="language"
            value="Japanese"
        
          />
          <label htmlFor="japanese">Japanese</label>
        </div> */}
        <div className='flex gap-10 my-10 '>
            <div className='flex gap-10'>
                <Button size="lg"  variant="outline" className="bg-green-600 text-white rounded-lg p-5 text-center">
                    <EarOffIcon/>Sign
                </Button>

            </div>
            <div className='flex gap-5 '>
                <DropdownMenu>
                    <DropdownMenuTrigger size="lg"  variant="outline" className="bg-green-600 text-white rounded-lg px-5 text-center">
                    Language</DropdownMenuTrigger>
                    <DropdownMenuContent>
                        <DropdownMenuItem>Profile</DropdownMenuItem>
                        <DropdownMenuItem>Billing</DropdownMenuItem>
                        <DropdownMenuItem>Team</DropdownMenuItem>
                        <DropdownMenuItem>Subscription</DropdownMenuItem>
                    </DropdownMenuContent>
                </DropdownMenu>
                <ArrowRight  variant="outline" className="bg-green-600 text-white rounded my-3 text-center"/>
                <DropdownMenu>
                <DropdownMenuTrigger size="lg"  variant="outline" className="bg-green-600 text-white rounded-lg px-5 text-center">
                Language</DropdownMenuTrigger>
                <DropdownMenuContent>
                    <DropdownMenuItem>Profile</DropdownMenuItem>
                    <DropdownMenuItem>Billing</DropdownMenuItem>
                    <DropdownMenuItem>Team</DropdownMenuItem>
                    <DropdownMenuItem>Subscription</DropdownMenuItem>
                </DropdownMenuContent>
                </DropdownMenu>
            </div>
        </div>


        <Textarea placeholder="Type here to Translate your message."  className="my-10 border-green-600 border-2"/>
        <Button size="lg"  variant="outline" className="bg-green-600 text-white rounded-lg p-5 text-center">
            <Languages /> Translate
        </Button>
        <Textarea className="my-10  border-green-600 border-2" placeholder="Translated Text"/>
        <Button size="lg"  variant="outline" className="bg-green-600 text-white rounded-lg p-5 text-center">
            <Copy/>Copy
        </Button>
        </form>
    </div>
  );
};

export default SignTranslation;