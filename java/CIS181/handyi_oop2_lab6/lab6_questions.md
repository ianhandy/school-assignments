# Lab 6 Questions

**1. In MyAnimalCrossingVillagerList, change the attribute ARRAY_SIZE = 500; to ARRAY_SIZE = 20; What affect does this have? Did your program correctly tell the user that the island is full?**

When I changed ARRAY_SIZE to 20, the program could only hold 20 villagers instead of the full list. Since the ListOfNames array has way more than 20 names, the program hit the limit after adding 20 names and printed "The island is full!" for every name after that. So yes, the program correctly told the user the island was full. The rest of the program still worked fine with just those 20 villagers.

**2. Right at the top of the MyAnimalCrossingVillagerList class, you can see "implements VillagerListInterface". As previously mentioned this behaves a little bit like inheritance, but not quite. Look at the VillagerListInterface.java class, and notice there is no code, just method names. Why is this? In fact, this class uses the keyword interface. What is the purpose of interfaces?**

An interface only has method signatures with no actual code because it acts as a contract. It tells any class that implements it "you must have these methods," but it doesn't care how they're implemented. The purpose of interfaces is to define a standard set of behaviors that different classes can share. For example, you could have a MyAnimalCrossingVillagerList that uses an array internally, and someone else could write a different version that uses a linked list, but as long as they both implement VillagerListInterface, the rest of the code can use either one without caring about the internal details. This is different from inheritance because a class can implement multiple interfaces, and the interface doesn't provide any actual functionality — it just defines what methods need to exist.

**3. ListOfNames.java is a weird class. It has one private constructor, why do you think this is the case?**

The constructor is private so that nobody can create an instance of ListOfNames. Since the class is just meant to hold a static list of names and nothing else, there's no reason to ever make an object out of it. Making the constructor private prevents anyone from accidentally doing `new ListOfNames()` which would be pointless since all the data is accessed through the class itself, not through instances.

**4. ListOfNames.java also only has one attribute, which is an array of names. Why is it static?**

The names array is static because it belongs to the class itself rather than any instance. Since the constructor is private and you can't create instances of the class, the only way to access the data is through the class name directly, like `ListOfNames.names`. Static means there's only one copy of the array shared across the entire program, which makes sense because the list of Animal Crossing villager names never changes and doesn't need separate copies.

**5. ListOfNames.java is only used to store a bunch of names, and nothing more. This can also be done with a text file. What might be some benefits of doing it this way, vs using a text file?**

Storing the names directly in a Java class has a few advantages over a text file. First, you don't have to deal with file I/O — no worrying about FileNotFoundException, no Scanner or BufferedReader setup, and no try-catch blocks just to read some names. Second, the data is compiled with the program, so there's no chance of the file being missing or in the wrong directory at runtime. Third, since it's part of the compiled code, accessing the array is faster than reading from a file on disk. Finally, if someone misspells a name or makes a typo, the compiler can catch certain issues at compile time rather than having a silent error at runtime.
