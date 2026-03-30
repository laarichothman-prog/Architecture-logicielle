# TP3 - Architecture Distribuée

Application distribuée avec Node.js, Docker, MongoDB, Redis, RabbitMQ et Nginx.

## Tech Stack
Node.js · Express · MongoDB · Redis · RabbitMQ · Nginx · Docker

## Architecture
```
Postman → Nginx:80 → Node.js:3001 / :3002
Node.js → MongoDB  (stockage persistant)
Node.js → Redis    (cache GET /commandes, TTL 30s)
Node.js → RabbitMQ (notifications asynchrones)
```

## Lancement
```bash
docker-compose up --build
```

## Vérification
| URL | Résultat |
|---|---|
| http://localhost/health | Nginx + Node.js OK |
| http://localhost:3001/health | Instance-1 |
| http://localhost:3002/health | Instance-2 |
| http://localhost:15672 | RabbitMQ UI (admin/admin) |

## Tests Postman

### POST /commandes
```json
{
  "produit": "Laptop Dell XPS",
  "quantite": 2,
  "client": "Ahmed Benali"
}
```

### GET /commandes
- 1er appel → source: MongoDB
- 2ème appel → source: Cache Redis

> **Course:** Architecture Logicielle — ENSA BM · Pr. BE ELBAGHAZAOUI
