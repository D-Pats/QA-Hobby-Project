"use strict"

const output = document.querySelector("#output");

document.querySelector("div > form").addEventListener("submit", function (event) {
    event.preventDefault();

    console.log("thisL ", this);

    const searchTeam = this.searchTeam.value;

    console.log("dataL", searchTeam);

    axios.get("http://localhost:8080/getRiders")
        .then(res => {
            console.log("resL", res);
            this.reset();
            this.searchTeam.focus;
            renderRidersByTeam(searchTeam);
        }).catch(err => console.log(err));

})


document.querySelector("section > form").addEventListener("submit", function (event) {
    event.preventDefault();

    console.log("THIS: ", this);

    const data = {
        riderName: this.riderName.value,
        teamName: this.teamName.value,
        sponsorName: this.sponsorName.value
    }

    console.log("DATA:", data);

    axios.post("http://localhost:8080/createRiders", data)
        .then(res => {
            console.log("RES:", res);
            this.reset();
            this.riderName.focus;
            renderRiders();
        }).catch(err => console.error(err));

})



function renderRiders() {
    axios.get("http://localhost:8080/getRiders")
        .then(res => {
            console.log("Riders: ", res.data);
            output.innerHTML = "";
            for (let rider of res.data) {
                const riderCol = document.createElement("div");
                riderCol.className = "col";

                const riderCard = document.createElement("div");
                riderCard.className = "card";
                riderCol.appendChild(riderCard);

                const riderDiv = document.createElement("div");
                riderDiv.className = "card-body";
                riderCard.appendChild(riderDiv);

                const riderRiderName = document.createElement("h2");
                riderRiderName.innerText = rider.riderName;
                riderDiv.appendChild(riderRiderName);

                const teamName = document.createElement("p");
                teamName.innerText = "Team: " + rider.teamName;
                riderDiv.appendChild(teamName);

                const sponsorName = document.createElement("p");
                sponsorName.innerText = rider.sponsorName;
                riderDiv.appendChild(sponsorName);

                const riderDelete = document.createElement('button');
                riderDelete.innerText = "DELETE";
                riderDelete.className = "btn btn-outline-danger";
                riderDelete.addEventListener("click", () => {
                    console.log("Rider: ", rider);
                    deleteRiders(rider.id);
                });
                riderDiv.appendChild(riderDelete);

                const riderUpdate = document.createElement('button');
                riderUpdate.innerText = "UPDATE";
                riderUpdate.className = "btn btn-outline-warning";
                riderUpdate.addEventListener("click", () => {
                    console.log("Rider: ", rider);
                    updateRiders(rider.id);
                });
                riderDiv.appendChild(riderUpdate);

                output.appendChild(riderCol);
            }
        })
        .catch(err => console.error(err));
}

const deleteRiders = (id) => {
    axios.delete("http://localhost:8080/removeRiders/" + id)
        .then(res => {
            console.log("Delete successful");
            renderRiders();
        }).catch(err => console.error(err));
}

const updateRiders = (id) => {
    if (this.riderName.value !== "" && this.teamName.value !== "" && this.sponsorName.value !== "") {
        axios.patch("http://localhost:8080/updateRiders/" + id + "?riderName=" + this.riderName.value + "&teamName=" + this.teamName.value + "&sponsorName=" + this.sponsorName.value)
            .then(res => {
                console.log("Update successful");
                renderRiders();
            }).catch(err => console.log(err));
    }
    else if (this.teamName.value !== "" && this.sponsorName.value !== "") {
        axios.patch("http://localhost:8080/updateRiders/" + id + "?teamName=" + this.teamName.value + "&sponsorName=" + this.sponsorName.value)
            .then(res => {
                console.log("Update successful");
                renderRiders();
            }).catch(err => console.log(err));
    }
    else if (this.riderName.value !== "" && this.sponsorName.value !== "") {
        axios.patch("http://localhost:8080/updateRiders/" + id + "?riderName=" + this.riderName.value + "&sponsorName=" + this.sponsorName.value)
            .then(res => {
                console.log("Update successful");
                renderRiders();
            }).catch(err => console.log(err));
    }
    else if (this.riderName.value !== "" && this.teamName.value !== "") {
        axios.patch("http://localhost:8080/updateRiders/" + id + "?riderName=" + this.riderName.value + "&teamName=" + this.teamName.value)
            .then(res => {
                console.log("Update successful");
                renderRiders();
            }).catch(err => console.log(err));
    }
    else if (this.riderName.value !== "") {
        axios.patch("http://localhost:8080/updateRiders/" + id + "?riderName=" + this.riderName.value)
            .then(res => {
                console.log("Update successful");
                renderRiders();
            }).catch(err => console.log(err));
    }
    else if (this.teamName.value !== "") {
        axios.patch("http://localhost:8080/updateRiders/" + id + "?teamName=" + this.teamName.value)
            .then(res => {
                console.log("Update successful");
                renderRiders();
            }).catch(err => console.log(err));
    }
    else if (this.sponsorName.value !== "") {
        axios.patch("http://localhost:8080/updateRiders/" + id + "?sponsorName=" + this.sponsorName.value)
            .then(res => {
                console.log("Update successful");
                renderRiders();
            }).catch(err => console.log(err));
    }
    else {
        alert("Fields must not be blank when updating.");
    }
}

function renderRidersByTeam(searchTeam) {
    axios.get("http://localhost:8080/getRiders")
        .then(res => {
            console.log("Riders: ", res.data);
            output.innerHTML = "";
            for (let rider of res.data) {
                if (rider.teamName == searchTeam) {
                    const riderCol = document.createElement("div");
                    riderCol.className = "col";

                    const riderCard = document.createElement("div");
                    riderCard.className = "card";
                    riderCol.appendChild(riderCard);

                    const riderDiv = document.createElement("div");
                    riderDiv.className = "card-body";
                    riderCard.appendChild(riderDiv);

                    const riderRiderName = document.createElement("h2");
                    riderRiderName.innerText = rider.riderName;
                    riderDiv.appendChild(riderRiderName);

                    const teamName = document.createElement("p");
                    teamName.innerText = "Team: " + rider.teamName;
                    riderDiv.appendChild(teamName);

                    const sponsorName = document.createElement("p");
                    sponsorName.innerText = rider.sponsorName;
                    riderDiv.appendChild(sponsorName);

                    const riderDelete = document.createElement('button');
                    riderDelete.innerText = "DELETE";
                    riderDelete.className = "btn btn-outline-danger";
                    riderDelete.addEventListener("click", () => {
                        console.log("Rider: ", rider);
                        deleteRiders(rider.id);
                    });
                    riderDiv.appendChild(riderDelete);

                    const riderUpdate = document.createElement('button');
                    riderUpdate.innerText = "UPDATE";
                    riderUpdate.className = "btn btn-outline-warning";
                    riderUpdate.addEventListener("click", () => {
                        console.log("Rider: ", rider);
                        updateRiders(rider.id);
                    });
                    riderDiv.appendChild(riderUpdate);

                    output.appendChild(riderCol);
                } else {
                    const errorOccured = document.createElement("p");
                    errorOccured.innerText = "Error Occurred";
                }}
            })
        .catch(err => console.error(err));
}

renderRiders();