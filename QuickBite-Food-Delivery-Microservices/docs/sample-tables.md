# Sample database tables

The project creates these tables automatically through JPA:

Restaurant:
- id
- name
- location

Menu:
- id
- restaurant_id
- item_name
- price

Order:
- order_id
- user_id
- restaurant_id
- total_amount
- status

Payment:
- id
- order_id
- amount
- payment_status

This maps to the sample tables in the assignment.
