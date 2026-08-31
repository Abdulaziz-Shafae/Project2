# Car Pooling System

## New Features

The original project requirements were expanded with additional functionality to make the system more interactive and realistic.

### Account System
- Create a new passenger account.
- Sign in using a 4-digit passenger ID.
- Prevent duplicate IDs.
- Validate that IDs contain numbers only.
- New accounts start as `NonSubPass`.

### Discount Codes
- Non-subscribers can enter a discount code when creating an account.
- Discount codes are validated against a stored list.
- Invalid codes can be retried.

### Subscription System
Passengers can change their subscription status from the user menu.

- Users can subscribe or unsubscribe at any time.
- Trip history is preserved when changing subscription type.

### Car Reservation
Users can:

- View all cars.
- View each car's route and base price.
- Reserve a car using its car code.
- Receive an error if the car is full.
- Receive an error if the car has zero capacity.
- Automatically calculate the final trip price based on passenger type.

### Routes
Users can view available routes including:

- Pick-up location
- Destination
- Base trip price

### Trip History
Every successful reservation is stored in the passenger's trip history.

The history includes:

- Car code
- Final trip cost
Since the trip history belongs to the signed-in passenger, the passenger ID and name are not repeated.

### Finished Trips
Passengers can mark a reserved trip as finished.

When a trip is finished:

- The trip is moved from `Reserved Trips` to `Finished Trips`.
- The finished trip remains available in the passenger's history.
- The system extracts the car code from the stored trip information.
- The matching car is found using its car code.
- One passenger seat is released from the car.
- The car capacity is updated automatically.
- The user is asked for confirmation before finishing a trip.
- Invalid trip numbers are handled and the user can retry.
  
### Input Validation & Exception Handling
The system handles several invalid inputs:

- Non-numeric menu choices.
- Invalid 4-digit IDs.
- Duplicate passenger IDs.
- Invalid car codes.
- Invalid discount codes.
- Cars with zero capacity.
- Cars that have reached maximum capacity.
- Invalid trip numbers.
- Invalid yes/no confirmation input.

## OOP Concepts Used

- Inheritance
- Abstraction
- Encapsulation
- Polymorphism
- Method overriding
- Abstract methods
- `ArrayList`
- Exception handling
- `instanceof`
- Object relationships

## Main Classes

- `Passenger` — Abstract parent class.
- `SubPass` — Subscriber passenger with 50% discount.
- `NonSubPass` — Non-subscriber with optional 10% coupon.
- `Car` — Stores car information, route and capacity.
- `Route` — Stores pick-up, destination and trip price.
- `Project_2` — Main application, menus and system logic.

## Technologies

- Java
- Object-Oriented Programming (OOP)
- Java Exception Handling
- ANSI terminal styling
