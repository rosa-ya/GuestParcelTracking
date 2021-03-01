# Guest Parcel Microservice Tracker

#Scenario
Receptionists have to accomplish various tasks throughout the day when operating a hotel. One of those tasks is to
 accept parcels for guests.
* It happens, that receptionists accept parcels for guests, that was already checked out of the hotel.
* It happens from time to time, that guests forget to pick up their parcels before check-out and even forget it then.

#Requirements
1. The receptionist needs a tracking tool that knows to any given time which guests are checked into the hotel and have not checked out,
 to allow the receptionist to decide whether to accept the parcel or not.
2. The tracking tool should further allow the receptionist to check for parcels available for pick-up when the guest is checking out.

#General info
I implement three microservices:
1. A service registry (Eureka Server),
2. Two REST services (Parcel and Guest) which register themselves at the registry (Eureka Client) .
* Service Discovery

Client-side service discovery allows services to find and communicate with each other without hard-coding hostname and port. The microservice style of architecture is not so much about building individual services so much as it is making the interactions between services reliable and failure-tolerant. Spring Cloud helps to manage that complexity with a service registry like Eureka and client-side load-balancing. A service registry is a phone book for your microservices. Each service registers itself with the service registry and tells the registry where it lives and perhaps other service-specific metadata - things that other services can use to make informed decisions about it. Clients can ask questions about the service topology and service capabilities. There are several popular options for service registries. Netflix built and then open-sourced their own service registry, Eureka. 
* Two REST services

Both REST Services use same database. Database has 2 tables, one for parcel information and one for guest information. Parcel table has ‘guestId’ field to show that this parcel belongs to which guest.
With Guest service, we can check the guest is in hotel or not, if the guest is in hotel, Guest service call Parcel service to add parcel to DB. Also, when guest wants to check out, receptionist check if there is parcel for them or not and after that update their checkout field in DB. For checking parcel availability for guest again parcel service has been called.
In Parcel service we can check parcel availability for guest when guest wants to check out and also if receptionist take parcel for gust, can add it to Database.


 

