window.onload = async function () {
    const fromSelect = document.getElementById("from");
    const toSelect = document.getElementById("to");

    const response = await fetch("https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies.json");
    const data = await response.json();

    for (let code in data) {
        const optionFrom = document.createElement("option");
        const optionTo = document.createElement("option");

        optionFrom.value = optionTo.value = code;
        optionFrom.text = optionTo.text = `${code.toUpperCase()} - ${data[code]}`;

        fromSelect.appendChild(optionFrom.cloneNode(true));
        toSelect.appendChild(optionTo);
    }

    fromSelect.value = "eur";
    toSelect.value = "usd";
};
async function convertCurrency() {
    const amount = parseFloat(document.getElementById("amount").value);
    const from = document.getElementById("from").value;
    const to = document.getElementById("to").value;

    if(!amount || amount <= 0){
        alert("pls enter a valid amount!")
        return
    }
	try{
	const response = await fetch(`convert?from=${from}&to=${to}&amount=${amount}`);
    const data = await response.json();
	
	if(data.error){
		alert(data.error);
		return
	}
	
    document.getElementById("result").value = data.result;
	
	} catch (err){
		alert("something is wrong. Try again later.")
		console.error(err);
	}
	
}
