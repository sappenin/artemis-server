---
description: Programmable money using configurable Payment Pointers.
---

# Interledger Artemis

## Status

![&amp;lt;a href=&quot;https://github.com/sappenin/java-ilp-connector/blob/master/LICENSE&quot;&amp;gt;&amp;lt;img src=&quot;https://img.shields.io/github/license/sappenin/java-ilp-connector.svg&quot;&amp;gt;&amp;lt;/a&amp;gt;](https://img.shields.io/github/license/sappenin/java-ilp-connector.svg)

Hello world, this is the license: \[img [https://img.shields.io/github/license/sappenin/java-ilp-connector.svg](https://img.shields.io/github/license/sappenin/java-ilp-connector.svg)\]\(http://example.com\).



## Background

[Payment Pointers](https://paymentpointers.org/) are a standardized identifier for payment accounts. In the same way that an email address provides an identifier for a mailbox in the email ecosystem, a payment pointer is used by an account holder to share the details of an account with a counterparty.

A Payment Pointer resolves to a URL \(using the https scheme\) that provides the location of a payment initiation service at which the counterparty can initiate a payment [to](https://github.com/interledger/rfcs/blob/master/0009-simple-payment-setup-protocol/0009-simple-payment-setup-protocol.md) or [from](https://github.com/interledger/rfcs/blob/master/0036-spsp-pull-payments/0036-spsp-pull-payments.md) the owner of the Payment Pointer.

## Features

1. **Proxy Pointers**
   1. Goal: Enable a sender application \(i.e., iOS wallet\) to peer with a connector directly and send money to a pointer that forwards to another pointer.
   2. Create ForwardingPointer \(e.g., `$wallet.ilpv4.dev/123`. Enter the forwarding pointer \(e.g., `$wallet.ilpv4.dev/john`. In the iOS app, make a payment to `$wallet.ilpv4.dev/123` and see that the money is deposited into john’s account.
2. **Buffered Proxy Pointer**
   1. When receiving to a payment pointer, the actual end-device may not be online. Thus, this type of pointer will buffer a payment into its own account, and only once the owner of the PP connects will the payment actually be streamed to the destination pointer.
   2. For the sender, the payment will appear to have been fulfilled \(the receiver must trust the ILSP not to steal money here\).
3. **Large-value Proxy Pointer**
   1. Similar to Forwarding Pointers, except that the sender doesn’t stream $$. Instead, only a single packet is sent to PP, which then instructs the ILSP to stream using its connector. Connection. Allows a low-powered device to instruct a service-provider to stream on its behalf.
   2. Question: Should this instead just be a REST endpoint? E.g., it will be useful to get information back about the payment stream.
   3. Make a single-packet, large payment to a PP \(the data-component should have a payment-id for idempotence\). The backend-software will either fulfill or reject this packet \(or do nothing, in which case the client can retry\).
   4. Once this packet is received by the PP ILSP, it will then stream this payment over the interledger.
4. **Subscriptions**
   1. Use the invoice-spec to support subscriptions out of the Wallet.

