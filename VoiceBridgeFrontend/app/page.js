import React from "react";
import Image from "next/image";
import { Button } from "@/components/ui/button";
import { Card, CardHeader, CardTitle, CardContent } from "@/components/ui/card";
import { ArrowRight, Brain, Calendar, Clock, FileOutputIcon, Languages, LanguagesIcon, LinkIcon, LucideTextQuote, Text, TextCursorInput } from "lucide-react";
import Testimonials from "@/components/testimonials";
import Link from "next/link";
import TestimonialsCarousel from "@/components/testimonials";

export default function Home() {
  const features = [
    {
      icon: Languages,
      title: "Multiformat Translation",
      description: "Translate across text, speech, and images using one unified platform.",
    },
    {
      icon: Brain,
      title: "AI-Powered Language Detection",
      description: "Automatically detects the source language for seamless translation.",
    },
    {
      icon: FileOutputIcon,
      title: "Real-Time Output Preview",
      description: "View translated text, listen to audio output, or see translated visuals instantly.",
    },
  ];
  
  const howItWorks = [
    {
      step: "Input Your Content",
      description: "Users can input text, upload images with text, or record/upload audio. The system detects the input type and uses AI models like OCR for images, speech-to-text for audio, and NMT (Neural Machine Translation) for translating the content into the selected language."
    },
    {
      step: "Language Detection",
      description: "Once content is submitted, VerseAI automatically detects the source language using advanced AI models, ensuring seamless and accurate translation without manual selection."
    },
    {
      step: "Select Output Format",
      description: "Choose whether you want your translated result as plain text, synthesized voice, or an overlaid image version."
    },
    {
      step: "View and Share",
      description: "Get instant previews of the translation in your chosen format. Easily download or share the translated content with others."
    }
  ];
  
  
  return (
      <main className="container mx-auto px-4 py-16">
        {/* Heero section */}
        <div className="flex flex-col lg:flex-row items-center justify-between gap-12 mb-24">
        <div className="lg:w-1/2">
          <h1 className="text-7xl font-extrabold bg-gradient-to-br from-green-600 to-green-400 bg-clip-text tracking-tighter text-transparent pr-2 pb-6">
          Translate Anything — Text, Voice, or Image
          </h1>
          <p className="text-xl text-gray-600 mb-10">
           An AI-Powered Translation for a Connected World.
          </p>
          <Link href={"/translation"}>
            <Button size="sm"  variant="secondary" className="bg-green-600 text-white rounded-lg p-5 text-center">
              Get Started <ArrowRight className="ml-2 h-5 w-5" />
            </Button>
          </Link>
        </div>
        <div className="lg:w-1/2 flex justify-center">
          <div className="relative w-full max-w-md aspect-square">
            <Image
              src="/translation.png"
              alt="Scheduling illustration"
              layout="fill"
              objectFit="contain"
            />
          </div>
        </div>
      </div>
      {/* Key Features Section */}
      <div className="mb-24">
        <h2 className="text-3xl font-bold text-center mb-12 text-green-600">
          Key Features
        </h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          {features.map((feature, index) => (
            <Card key={index}>
              <CardHeader>
                <feature.icon className="w-12 h-12 text-green-500 mb-4 mx-auto" />
                <CardTitle className="text-center text-green-600">
                  {feature.title}
                </CardTitle>
              </CardHeader>
              <CardContent>
                <p className="text-center text-gray-600">
                  {feature.description}
                </p>
              </CardContent>
            </Card>
          ))}
        </div>
      </div>

      {/* Testimonials Section */}
      <div className="mb-24">
        <h2 className="text-3xl font-bold text-center mb-12 text-green-600">
          What Our Users Say
        </h2>
        <TestimonialsCarousel />
      </div>

      {/* How It Works Section */}
      <div className="mb-24">
        <h2 className="text-3xl font-bold text-center mb-12 text-green-600">
          How It Works
        </h2>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8">
          {howItWorks.map((step, index) => (
            <div key={index} className="text-center">
              <div className="bg-green-100 rounded-full w-16 h-16 flex items-center justify-center mx-auto mb-4">
                <span className="text-green-600 font-bold text-xl">
                  {index + 1}
                </span>
              </div>
              <h3 className="font-semibold text-lg mb-2">{step.step}</h3>
              <p className="text-gray-600">{step.description}</p>
            </div>
          ))}
        </div>
      </div>

      {/* CTA Section */}
      <div className="bg-green-600 text-white rounded-lg p-8 text-center">
        <h2 className="text-3xl font-bold mb-4">
          Ready to Translate?
        </h2>
        <p className="text-xl mb-6">
          Join thousands of professionals who trust VerseAI for translation.
        </p>
        <Link href={"/dashboard"}>
          <Button size="lg" variant="secondary" className="text-green-600">
            Start For Free <ArrowRight className="ml-2 h-5 w-5" />
          </Button>
        </Link>
      </div>
      </main>
  );
}
