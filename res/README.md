#README #
###Overview
The Project works on converting the management of a Sanctuary from manual to a computerized software program.
List of features. This is aimed to handle all the functionalities that are required to bw handled by a Sanctuary.

The Design consists of two interfaces.
1. Sanctuary
2. Animal

Classes JungleFriendsSanctuary and Monkey implement these Interfaces respectively.
Jungle Friends class has the following Features.
1. Create a List of Species in alphabetical order.
2. Search for species
3. Create a list of Names in Alphabetical order.
4. Transfer a Monkey
5. Create a Shopping List with Favourite Food and Quantity.

There are twp kinds of Housing in our case.
1. Isolation
2. Enclosure

The Monkeys are first Enrolled in Isolation where they are given Medical attention, assigned a unique id, Name, Species
Approximate age determined, Sex determined, favourite food Determined.

Enclosures are configured to house a particular species at a time  but can be repurposed for a different 
species if and only if they are empty.
The capacity of an enclosure taken to be 20 square meters in our case and
the size of the monkeys in the enclosure are as

1. Small monkeys (<10 cm) require 1 square meter each.
2. Medium monkeys (10 to 20 cm) require 5 square meters.
3. large monkeys (>20 cm) require 10 square meters.



###How To Run

The program has an executable file(JAR). To run the file we need to run the following command in a terminal.

<code>
java -jar (path)/(filename).jar
</code>

Description of Examples. In many assignments, we will ask you to provide examples of your program's execution. Depending upon the assignment, the details of the format of these examples will vary. Regardless, you should provide a description of what each example represents/does. For example:

Run 1 -- ExampleRun1.txt:
1. Display List of Monkeys sorted alphabetically by Species.
2. Search for a Species to find its location.
3. Create a Sign for a particular unit of Housing with details of Occupants like Name, Gender, Favourite Food and Species.
4. Display List of Monkeys sorted alphabetically by Names.
5. Create a Shopping List with Food Items and Corresponding Quantity based on the requirement from the Occupants.
6. Move Monkey from Isolation to Enclosure Once he is healthy/given Medical Attention.
7. Move Monkey from Enclosure to Isolation once he needs Medical Attention.


###Design/Model Changes
 After the first design meeting changes were made keeping the following points in mind.
1. Reduce Redundancy
2. Appropriate use of Enums.
3. Update the interface with methods.
4. Assign Each Unit a unique identifier.
5. Use Exceptions to handle cases.

While implementing I have made changes to the design and added Hashmap to the list of data types used.


###Assumptions 
For the Purpose of development and testing of a small unit of a larger application we have made a few assumptions in our
case for convenience. The assumptions we have made in our case are as follows.

1. We have assumed that there are initially n and m isolations and enclosures in the sanctuary. 
2. We have assumed that a monkey which cannot be accepted by the sanctuary will be accepted by a partner Sanctuary.
3. We have assumed that the max size of an enclosure is 20 square meters.
4. We have assumed that there is no database connected as of now.

###Limitations
The assumptions we have made have their limitations which can be resolved when we link it to the main application and
database.
Apart from these the application doesn't consider the following limitations.
 * We cannot match monkeys based on need and relationship.
 * We have not considered matching animals of different sex.
 * We have not considered adding a bulk of animals in one go.
 * We are just considering two types of housing in our case.
 * To update the list of Favourite foods code needs to be changed.



###Citations
* https://www.geeksforgeeks.org/
* https://riptutorial.com/java
* https://java2blog.com/

These websites have been really helpful for learning and implementing new data types and functionalities in the prioject.
They have helped me to refine and redesign the project to best fit the requirment.