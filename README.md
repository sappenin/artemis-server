# Payment Pointer Server
A java application that hosts [Payment Pointers](https://paymentpointers.org). 

## Overview
Payment Pointers are a standardized identifier for payment accounts. In the same way that an email address provides an identifier for a mailbox in the email ecosystem, a payment pointer is used by an account holder to share the details of an account with a counter-party.

A Payment Pointer resolves to a URL (using the https scheme) that provides the location of a payment initiation 
service at which the counter-party can initiate a payment [to](https://github.com/interledger/rfcs/blob/master/0009-simple-payment-setup-protocol/0009-simple-payment-setup-protocol.md) or [from](https://github.com/interledger/rfcs/blob/master/0036-spsp-pull-payments/0036-spsp-pull-payments.md) the owner of the Payment Pointer.
