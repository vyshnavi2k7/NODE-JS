const express = require("express");
const app = express();

app.use(express.json());
let students = [
    {id:"25WH1A05N0",name:"Vyshnavi",age:19},
    {id:"25WH1A05R",name:"Rishitha",age:18},
];

//GET - Read all students
app.get("/students",(req,res)=>{
    res.json(students);
});

//POST - Add a student
app.post("/students",(req,res)=>{
    students.push(req.body);
    res.send("Student added successfully");
});

//PUT - Update a student
app.put("/students/:id",(req,res)=>{
    let student=students.find(s=>s.id==req.params.id);
    if(student){
        student.name=req.body.name;
        student.age=req.body.age;
        res.send("Student updates successfully");
    }else{
        res.send("Student not found");
    }
});

//DELETE - Delete a student
app.delete("/students/:id",(req,res)=>{
   students=students.filter(s => s. id!=req.params.id);
   res.send("Student deleted successfully");
});

app.listen(3000,()=>{
    console.log("Server running on port http://localhost:3000");
});