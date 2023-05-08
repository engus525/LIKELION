
document.getElementById("changeName").addEventListener("click", function() {
    const newName = document.getElementById("in_name").value;
    localStorage.setItem("name", newName);
    document.getElementById('in_name').value = "";
    alert("이름이 변경되었습니다.");
});

document.getElementById("changeBirth").addEventListener("click", function() {
    const newBirth = document.getElementById("in_birth").value;
    localStorage.setItem("birth", newBirth);
    document.getElementById('in_birth').value = "";
    alert("생일이 변경되었습니다.");
});

document.getElementById("changeMajor").addEventListener("click", function() {
    const newMajor = document.getElementById("in_major").value;
    localStorage.setItem("major", newMajor);
    document.getElementById('in_major').value = "";
    alert("전공이 변경되었습니다.");
});

document.getElementById("changeContact").addEventListener("click", function() {
    const newEmail = document.getElementById("in_contact").value;
    localStorage.setItem("email", newEmail);
    document.getElementById('in_contact').value = "";
    alert("이메일이 변경되었습니다.");
});