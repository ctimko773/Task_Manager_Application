
async function bubbleAnimate() {
    const btn = document.querySelector('#bubble');

    btn.disabled = true;

    const speed = 100; // Adjust the speed of the animation (lower is faster)
    const status = document.getElementById('sort-status');

    let swaps = 0;
    let passses = 0;
    let time = 0;

    const timer = setInterval(() => {
        time++;
        timerdisplay.textContent = `Time: ${seconds.toFixed()}s`;
    }, 1000);

    for (let i = 0; i < contacts.length; i++) {
        let swapped = false;
        passses++;
        status.textContent = `Pass: ${passses}, Swaps: ${swaps}, Time: ${time}s`;

        for (let j = 0; j < contacts.length - i - 1; j++) {
            await new Promise(resolve => setTimeout(resolve, speed)); 
            if (contacts[j].lastName.toLowerCase() > contacts[j + 1].lastName.toLowerCase()) {
        
                [contacts[j], contacts[j + 1]] = [contacts[j + 1], contacts[j]];
                swapped = true;
                swaps++;

                renderTable(contacts); 

            }

        }
        if (!swapped) break;
    }

    btn.disabled = false;
}


let searchTimeout = [];

function linearSearch() {
    searchTimeout.forEach(t => clearTimeout(t));
    searchTimeout = [];

    const input = document.getElementById('search-input').value.toLowerCase();
    const status = document.getElementById('search-status');
    const rows = document.querySelectorAll('#contact-body tr');

    rows.forEach(row => row.classList.remove('found', 'searching'));

    if (input === '') {
        status.textContent = 'Please enter a search term.';
        return;
    }


    let matchCount = 0;
    let steps = 0;

    for (let i = 0; i < contacts.length; i++) {
        (function(index) {
        steps ++;

        const t1 = setTimeout(() => {
            rows[index].classList.add('searching');

            const t2 = setTimeout(() => {
                rows[index].classList.remove('searching');


                if (contacts[index].lastName.toLowerCase().startsWith(input)) {
                    rows[index].classList.add('found');
                    matchCount++;
                }
                if (i === contacts.length - 1) {
                    status.textContent = matchCount > 0 
                    ? `Found ${matchCount} match${matchCount > 1 ? 'es' : ''} in ${steps} steps.`
                    : `No matches found after ${steps} steps.`;
                }
            }, 150);

            searchTimeout.push(t2);

        }, index * 200);

        searchTimeout.push(t1);
    })(i);
}
}

document.getElementById('search-input').addEventListener('input', linearSearch);