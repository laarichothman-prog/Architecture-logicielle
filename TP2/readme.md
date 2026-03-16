# TP2 - Monolithe Modulaire

Restructuration du monolithe TP1 en modules métier distincts avec DTOs, MapStruct et Service Layer.

---

## Architecture
```
com.ecommerce.monolith
├── product/    → indépendant
├── customer/   → indépendant  
└── order/      → dépend de ProductService et CustomerService uniquement
```

---

## Tech Stack
Java 17 · Spring Boot · Spring Data JPA · MapStruct · Lombok · PostgreSQL

---

## API Endpoints

| Method | URL | Description |
|---|---|---|
| GET/POST | `/api/products` | List / Create product |
| GET/PUT/DELETE | `/api/products/{id}` | Get / Update / Delete product |
| GET/POST | `/api/customers` | List / Create customer |
| GET/PUT/DELETE | `/api/customers/{id}` | Get / Update / Delete customer |
| GET/POST | `/api/orders` | List / Create order |
| PATCH | `/api/orders/{id}/cancel` | Cancel order |
| GET | `/api/orders/customer/{id}` | Order history by customer |

---

## Run
```bash
cd TP2/demo
./mvnw spring-boot:run
```

---

## TP2 Checklist
- [x] Modules Product, Customer, Order avec Entity, DTO, Mapper, Repository, Service, Controller
- [x] `customerExists(Long id)` dans CustomerService
- [x] Endpoint historique commandes `/api/orders/customer/{customerId}`
- [x] Order dépend uniquement des services publics, jamais des repositories directement

---

> **Course:** Architecture Logicielle — ENSA BM · Pr. BE ELBAGHAZAOUI