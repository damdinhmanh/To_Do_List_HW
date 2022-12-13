const btnGet = document.getElementById('btnGet');
const btnPost = document.getElementById('btnPost');
let bmiText = document.getElementById('bmi');

console.log(btnGet);

btnGet.addEventListener("click", async function searchWord() {
    try {
        let height = document.getElementById('height').value;
        let weight = document.getElementById('weight').value;

        let getBMI = await axios.get(`http://localhost:8080/bmi?height=${height}&weight=${weight}`);
        console.log(getBMI);
        bmiText.textContent = getBMI.data;

    } catch (error) {OK
        console.log(error);
    }
});

btnPost.addEventListener("click", async function postBMI(){
    try {
        const postBody = {
            "height": "155",
            "weight": "69"
        };

        let postBMI = await axios.post(`http://localhost:8080/bmi`, postBody, null);
        console.log(postBMI);


    } catch (error) {
        console.log(error);
    }
});


