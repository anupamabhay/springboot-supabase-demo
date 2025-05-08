# 📝 Spring Boot + Supabase Todo API

A simple RESTful Todo backend built with Spring Boot and connected to a Supabase PostgreSQL database.

## 🚀 Features

- Create, update (PATCH), delete, and list todos
- Supabase-hosted PostgreSQL database
- Environment variable support
- Lightweight, beginner-friendly architecture

---

## 🛠️ Prerequisites

- Java 17+
- Maven
- A Supabase project with a PostgreSQL database
- Optional: Docker (for containerization)

---

## 🔐 Environment Variables

This app uses environment variables for database credentials. You can set them manually or through a `.env` file (if using Docker):

### Required Variables

| Variable     | Description                    |
|--------------|--------------------------------|
| `DB_HOST`    | Supabase DB host               |
| `DB_PORT`    | Supabase DB port (usually 5432)|
| `DB_NAME`    | Database name (usually `postgres`) |
| `DB_USER`    | Supabase DB user (usually `postgres`) |
| `DB_PASS`    | Supabase DB password           |

### Option 1: Temporary (PowerShell / Command Line)

```powershell
$Env:DB_HOST = 'your-host.supabase.co'
$Env:DB_PORT = '5432'
$Env:DB_NAME = 'postgres'
$Env:DB_USER = 'postgres'
$Env:DB_PASS = 'your-supabase-password'
```

**### Option 2: Permanent (Windows user environment)**
[System.Environment]::SetEnvironmentVariable('DB_HOST', 'your-host.supabase.co', 'User')
[System.Environment]::SetEnvironmentVariable('DB_PORT', '5432', 'User')
[System.Environment]::SetEnvironmentVariable('DB_NAME', 'postgres', 'User')
[System.Environment]::SetEnvironmentVariable('DB_USER', 'postgres', 'User')
[System.Environment]::SetEnvironmentVariable('DB_PASS', 'your-password', 'User')

## 🧪 Running the Project

**1. Clone the repo:**
```bash
git clone https://github.com/your-username/supabase-springboot-todo.git
cd supabase-springboot-todo
```
**2. Set environment variables as above**

**3. Run the app:**
```bash
./mvnw spring-boot:run
```

App will start at http://localhost:8080


## API Endpoints

| Method | Endpoint          | Description    |
| ------ | ----------------- | -------------- |
| GET    | `/api/todos`      | List all todos |
| POST   | `/api/todos`      | Create a todo  |
| PATCH  | `/api/todos/{id}` | Update a todo  |
| DELETE | `/api/todos/{id}` | Delete a todo  |

**Example POST /api/todos**
```json
{
  "task": "Write documentation",
  "done": false
}
```
