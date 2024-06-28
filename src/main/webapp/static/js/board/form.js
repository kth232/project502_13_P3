window.addEventListener("DOMContentLoaded", function() {
    ClassicEditor.create(document.getElementById("content"), {
        height:350
    }).then((editor)=>{
        window.editor = editor; //promise 방식
    });
});