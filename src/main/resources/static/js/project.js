function test() {
    console.log('test')
    fetch('https://jsonplaceholder.typicode.com/todos/1')
        .then(response => response.json())
        .then(json => console.log(json))
}

function displayTextareaContent() {
    var number = ""
    var text = []
    var nnumberarea = document.getElementById("myNumberarea");
    var numbercontent = nnumberarea.value;
    console.log(numbercontent);

    var textarea = document.getElementById("myTextarea");
    var textcontent = textarea.value;
    console.log(textcontent);
    number = numbercontent
    text.push(textcontent)

    var json = JSON.stringify({id: number, content: text})
    console.log(json)


    var data = {
        name: "John",
        age: 30,
        email: "john@example.com"
    };

    fetch('https://api.example.com/endpoint', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(responseData => {
            console.log(responseData);
            // 서버 응답 데이터 처리
        })
        .catch(error => {
            console.error(error);
            // 에러 처리
        });

}