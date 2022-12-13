const API_URL = "http://localhost:8080/api/v1"

const todoListEl = document.getElementById("todolist");
let todos = [];

// Lấy ds todo và hiển thị
const getTodos = async () => {
    try {
        // Gọi GET API
        let res = await axios.get(`${API_URL}/todos`);
        console.log(res);
        todos = res.data; // Lưu lại dữ liệu trả về từ server;

        // Hiển thị lên trên giao diện
        renderTodos(todos);
    } catch (error) {
        console.log(error)
    }
}

const renderTodos = arr => {
    todoListEl.innerHTML = "";
    if(arr.length === 0) {
        todoListEl.innerHTML = '<li>Không có công việc nào trong danh sách</li>';
        return;
    }

    let html = "";
    arr.forEach(t => {
        html += `
            <li>
                <input id="checkId${t.id}" type="checkbox" ${t.status ? "checked" : ""}>
                <span id="spanId${t.id}" class=${t.status ? "todo-active" : ""}>${t.title}</span>
                <button onclick="updateTodo(${t.id})">Update</button>
                <button onclick="deleteTodo(${t.id})">Delete</button>
            </li>
        `
    });

    todoListEl.innerHTML = html;
}

const deleteTodo = async id => {
    console.log(id);

    try {
        await axios.delete(`${API_URL}/todos/${id}`);

        // Gọi API
        let res = await axios.get(`${API_URL}/todos`);
        console.log(res);
        todos = res.data; // Lưu lại dữ liệu trả về từ server;
        // Hiển thị lên trên giao diện
        renderTodos(todos);
    } catch (error) {
        console.log(error)
    }
}

const updateTodo = async id => {
    console.log(id);

    try {
        let checkValue = document.getElementById(`checkId${id}`).checked;
        let spanValue = document.getElementById(`spanId${id}`).textContent;
        console.log("Checkvalue=" + checkValue);
        console.log("Span=" + spanValue);

        const putBody = {
            "title": `${spanValue}`,
            "status": `${checkValue}`
        };

        await axios.put(`${API_URL}/todos/${id}`, putBody, null);

        // Gọi API
        let res = await axios.get(`${API_URL}/todos`);
        console.log(res);
        todos = res.data; // Lưu lại dữ liệu trả về từ server;
        // Hiển thị lên trên giao diện
        renderTodos(todos);
    } catch (error) {
        console.log(error)
    }
}

// Vừa vào trang sẽ gọi
getTodos();

//Add Todo
const addTodoBtn = document.getElementById("addToDo");
addTodoBtn.addEventListener("click", async function handler() {
    try {
        let inputTextVal = document.getElementById('inputToDo').value;
        const postBody = {
            "title": `${inputTextVal}`,
        };

        let postBMI = await axios.post(`${API_URL}/todos`, postBody, null);

        // Gọi API
        let res = await axios.get(`${API_URL}/todos`);
        console.log(res);
        todos = res.data; // Lưu lại dữ liệu trả về từ server;
        // Hiển thị lên trên giao diện
        renderTodos(todos);
    } catch (error) {
        console.log(error)
    }
});