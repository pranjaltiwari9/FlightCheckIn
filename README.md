# FlightCheckIn

Flight Check-In Receipt Generator

We all book flights online now and by default the baggage weight is 15 kg for which no extra charge is incurred. It might be a case, when the actual baggage weight at the time of Check-In be greater than 15 kg. For that, extra charges are incurred, usually 500/- for every 5 kg extra.

So what I did here is to get Passenger ID and Baggage Weight at the time of check-in, and print the updated receipt with a new and updated amount. If the amount paid while booking the ticket was 5000/- for 15 kg (by default) and at the time of check-in baggage weight is 18 kg then the receipt generated will have the new amount that is: 5500/- , updated baggage weight and other details for that passengerID. (Also, all these new changes are subsequently updated in the DataBase as well)

All three layers are implemented: Controller, Service and Repository. The main logic for this calculation is conventionally at the Service layer.

getReceipt()- @PutMapping [Gets the receipt and update details in DB]
URL Syntax – localhost:8080/getReceipt/{passengerID}/{baggageweight}

Besides this, We can also:

cancelBooking()- @DeleteMapping [Deletes the record from the DataBase]

bookTicket()- @PostMapping [Adds a new record to the DataBase]

getPassengerDetails()- @GetMapping [Fetches a particular record by passengerID]

getAllPassengers()- @GetMapping [Fetches all the records]

Apart from developing this application, I managed to do a JUnit test on Repository.

Looking forward to sharing more details and implementation of the project at the next FridayReviewMeet.

Feel free to contact me for any more details, code or implementation screenshots of the project.
