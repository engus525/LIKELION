const cname = document.getElementById("c_name");
const cbirth = document.getElementById("c_birth");
const cmajor = document.getElementById("c_major");
const cemail = document.getElementById("c_contact");

window.addEventListener("load", function () {
    const name = localStorage.getItem("name");
    if (name) {
        cname.innerHTML = name;
    }
    const birth = localStorage.getItem("birth");
    if (birth) {
        cbirth.innerHTML = birth;
    }
    const major = localStorage.getItem("major");
    if (major) {
        cmajor.innerHTML = major;
    }
    const email = localStorage.getItem("email");
    if (email) {
        cemail.innerHTML = email;
    }
});
