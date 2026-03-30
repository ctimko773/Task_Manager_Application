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

    for (let i = 0; i < tasks.length; i++) {
        let swapped = false;
        passses++;
        status.textContent = `Pass: ${passses}, Swaps: ${swaps}, Time: ${time}s`;

        for (let j = 0; j < tasks.length - i - 1; j++) {
            await new Promise(resolve => setTimeout(resolve, speed)); 
            if (tasks[j].taskName.toLowerCase() > tasks[j + 1].taskName.toLowerCase()) {
        
                [tasks[j], tasks[j + 1]] = [tasks[j + 1], tasks[j]];
                swapped = true;
                swaps++;

                renderTable(tasks); 

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
    const rows = document.querySelectorAll('#task-body tr');

    rows.forEach(row => row.classList.remove('found', 'searching'));

    if (input === '') {
        status.textContent = 'Please enter a search term.';
        return;
    }


    let matchCount = 0;
    let steps = 0;

    for (let i = 0; i < tasks.length; i++) {
        (function (index) {
        steps ++;

        const t1 = setTimeout(() => {
            rows[index].classList.add('searching');

            const t2 = setTimeout(() => {
                rows[index].classList.remove('searching');


                if (tasks[index].taskName.toLowerCase().startsWith(input)) {
                    rows[index].classList.add('found');
                    matchCount++;
                }
                if (i === tasks.length - 1) {
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