{\rtf1\ansi\ansicpg1252\cocoartf1561\cocoasubrtf400
{\fonttbl\f0\fnil\fcharset0 Menlo-Bold;\f1\fnil\fcharset0 Menlo-Regular;\f2\fnil\fcharset0 Menlo-Italic;
\f3\fnil\fcharset0 Menlo-BoldItalic;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue109;\red15\green112\blue3;\red82\green0\blue103;
}
{\*\expandedcolortbl;;\csgenericrgb\c0\c0\c42745;\csgenericrgb\c5882\c43922\c1176;\csgenericrgb\c32157\c0\c40392;
}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0

\f0\b\fs24 \cf2 import 
\f1\b0 \cf0 java.util.*;\
\

\f0\b \cf2 public class 
\f1\b0 \cf0 FirstNonRecurringCharacter \{\
\
    
\f0\b \cf2 public static void 
\f1\b0 \cf0 main(String[] args)\
    \{\
        Character character = 
\f2\i firstNonRecurringCharacter
\f1\i0 (
\f0\b \cf3 "abc"
\f1\b0 \cf0 );\
        System.
\f3\i\b \cf4 out
\f1\i0\b0 \cf0 .println(character);\
    \}\
\
    
\f0\b \cf2 public static 
\f1\b0 \cf0 Character firstNonRecurringCharacter(String input)\
    \{\
        Set<Character> set = 
\f0\b \cf2 new 
\f1\b0 \cf0 LinkedHashSet<>();\
\
        
\f0\b \cf2 char
\f1\b0 \cf0 [] array = input.toCharArray();\
\
        
\f0\b \cf2 for
\f1\b0 \cf0 (
\f0\b \cf2 char 
\f1\b0 \cf0 a : array)\
        \{\
            
\f0\b \cf2 if
\f1\b0 \cf0 (!set.contains(a))\
            \{\
                set.add(a);\
            \}\
            
\f0\b \cf2 else\
            
\f1\b0 \cf0 \{\
                set.remove(a);\
            \}\
        \}\
\
        Character character = 
\f0\b \cf2 null
\f1\b0 \cf0 ;\
\
        
\f0\b \cf2 if
\f1\b0 \cf0 (!set.isEmpty())\
        \{\
            character = set.iterator().next();\
        \}\
\
        
\f0\b \cf2 return 
\f1\b0 \cf0 character;\
\
    \}\
\
\}\
\
\
}