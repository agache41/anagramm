Melda Dogan  1:34 PM
Write a Java program that checks if two texts are anagrams of each other.

Please use the english wikipedia entry for the definition of anagram.
The solution has to be in Java or Kotlin.
Feel free to use your favourite IDE, unit test frameworks, automated build system etc.
You can prioritize however you like (performance, readability, extensibility, …).
Googling is a good thing :)

>>>>>>>>>>>>

The solution calculates an intermediary key (Anagram Key) for a given text.

It basically creates a unique representation 
of the text with regard to the anagram space.

Examples :
a -> #97=1
b -> #98=1
foo -> #102=1#111=2
angel -> #97=1#101=1#103=1#108=1#110=1
glean -> #97=1#101=1#103=1#108=1#110=1

The chosen format is [#CharacterCode=Count]* repeated for every character and ordered by CharacterCode. 
The text is converted to lowercase and some characters are being removed :  ,:;'*+=(){}!§$%&/"><|._-#`´?!
This can be further configured.

By comparing the keys then we can than determine if the two texts are anagram of each other.

The advantage of the method is that is allows better usability in case more texts are involved,
caching, functional approach, usv.

It also allows us, if desired, 
to implement various variations of the anagrams, as is "almost anagram" : 
contains the same letters but the count may vary. A different equals will be then needed.

To test it use the main function or browse the tests. 
Feel free to add new entries in the test parametrisation.
Test examples from : 
https://www.yourdictionary.com/articles/examples-anagrams-functions

Mit freundlichen Grüßen,
regards,
Alexandru Agache
eMail:agache41@yahoo.com
Mob: 015167765317
