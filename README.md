# 🚀 Fawry Quantum Internship Challenge 3 — E-commerce System

This project is my solution for the **Fawry Rise Journey — Full Stack Development Internship Challenge**.
---

## 📌 Challenge Overview

Design and implement an **e-commerce system** with the following features:

✅ **Product Management**
- Define products with:
  - Name, price, and quantity.
  - Support for both expirable (e.g., Cheese, Biscuits) and non-expirable (e.g., TV, Mobile) items.
  - Some products may require shipping (e.g., Cheese, TV) while others may not (e.g., Mobile scratch cards). Every shippable item provides its weight.

✅ **Shopping Cart**
- Customers can add products to a cart with a specific quantity (not exceeding available stock).

✅ **Checkout Process**
- Print checkout details in the console:
  - Order subtotal (sum of item prices)
  - Shipping fees
  - Paid amount (subtotal + shipping)
  - Customer’s balance after payment

- Handle errors for:
  - Empty cart
  - Insufficient customer balance
  - Out-of-stock or expired products

✅ **Shipping Service**
- Collect all items needing shipping and send them to a `ShippingService` that accepts objects implementing an interface:
  - `String getName()`
  - `double getWeight()`

---

** Shipment notice **
2x Cheese        400g
1x Biscuits      700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese        200
1x Biscuits      150
----------------------
Subtotal         350
Shipping         30
Amount           380

