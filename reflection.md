Use this file to record your reflection on this assignment.

- **Which methods did you decide to `overload`, and why?**

     - moveIn(String name): To allow adding a resident by their name without requiring a Student object. This makes the method more flexible and user-friendly.
     - moveOut(String name, boolean notify): To allow removing a resident by their name with an option to notify them. This provides additional functionality for managing residents.
      - sellCoffee(int size, int nSugarPackets, int nCreams, boolean isTakeaway): To handle takeaway orders.
     - restock(int nCoffeeOunces, int nSugarPackets, int nCreams): To allow partial restocking of specific items.
     addTitle(String title, boolean isAvailable): To allow adding books with a specified availability status.
     - checkOut(String title, int days): To specify the number of days a book is borrowed.

- **What worked, what didn't, what advice would you give someone taking this course in the future?**

Overloading methods allowed us to provide more flexible and intuitive functionality for each class. It was challenging to make sure that overloaded methods didn’t conflict with existing methods or introduce ambiguity. I reccommend future students to plan class design carefully and think about how overloaded methods will improve usability without overcomplicating the code.
