const express = require("express");
const mysql = require("mysql2/promise");

const app = express();
app.use(express.json());

const db = mysql.createPool({
    host:"localhost",
    user:"root",
    password:"1234",
    database:"stddb"
})

//Test MYSQL connection
db.getConnection()
   .then(connection => {
    console.log("Connected to MySQL databases");
    connection.release();
})
.catch(error => {
    console.log("MySQL connection failed:",error.message);
});

//HOME
app.get("/",(req,res)=>{
    res.send("Welcome to HOME ");
});

//GET
app.get("/student",async (req,res)=>{
    try{
        const [rows] = await db.execute("SELECT * FROM student");
        res.json(rows);
    }catch(error){
        res.send("Database error: " + error.message);
    }
});

//POST
app.post("/student",async (req,res)=>{
    try{
        const {id ,name, roll_no } = req.body;
        await db.execute("INSERT INTO student (id, name, roll_no) VALUES (?, ?, ?)", 
            [id, name, roll_no]
        );
        res.send("Student added successfully");
    }catch(error){
        res.send("Database error: " + error.message);
    }
});

//PUT
app.put("/student/:id",async (req,res)=>{
    try{
        const {id, name, roll_no} = req.body;
        await db.execute("UPDATE student SET id = ?,name = ?, roll no = ? WHERE id=?",
            [id,name, roll_no, req.params.id]
        );
        res.send("Student updated successfully");
    }catch(error){
        res.send("Database error; " + error.message);
    }
});

//DELETE
app.delete("/student/:id",async (req,res)=>{
    try{
        await db.execute("DELETE FROM stddb WHERE id=?", 
            [req.params.id]
        );
        res.send("Student deleted successfully");
    }catch(error){
        res.send("Database error; " + error.message);
    }
});

app.listen(3000,() =>{
    console.log("server is running on port 3000");
});