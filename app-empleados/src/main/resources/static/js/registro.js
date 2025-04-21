
function cambiarIdioma() {
    const en = document.getElementById("toggle-idioma").checked;

    document.getElementById('titulo').innerText = en ? "Step 1: Personal Data" : "Paso 1: Información personal";
    document.getElementById('lbl-nombre-label').textContent = en ? "First name:" : "Nombre:";
    document.getElementById('lbl-apellido-label').textContent = en ? "Last name:" : "Apellidos:";
    document.getElementById('lbl-email-label').textContent = en ? "Email:" : "Email:";
    document.getElementById('lbl-dni-label').textContent = en ? "ID Number:" : "DNI:";
    document.getElementById('lbl-fecha-label').textContent = en ? "Date of birth:" : "Fecha de nacimiento:";

    document.getElementById('toggle-label').innerHTML = `
        <input type="checkbox" id="toggle-idioma" ${en ? "checked" : ""} onchange="cambiarIdioma()"> 
        ${en ? "View in Spanish" : "Ver en inglés"}
    `;
}

function mostrarPaso(numero) {
    const pasoActual = document.querySelector('.paso:not([style*="display: none"])');
    if (pasoActual) {
        const numeroActual = pasoActual.id.split('-')[1];
        if (!validarPasoActual(numeroActual)) return;
    }
    document.querySelectorAll('.paso').forEach(p => p.style.display = 'none');
    const nuevoPaso = document.getElementById(`paso-${numero}`);
    if (nuevoPaso) nuevoPaso.style.display = 'block';
}

function validarPasoActual(pasoActual) {
    const paso = document.getElementById(`paso-${pasoActual}`);
    const inputs = paso.querySelectorAll('input');

    for (let input of inputs) {
        if (!input.checkValidity()) {
            input.reportValidity();
            return false;
        }
    }
    return true;
}

function mostrarTodosLosPasos() {
    document.querySelectorAll('.paso').forEach(p => p.style.display = 'block');
}

function cambiarEstilos() {
    const activado = document.getElementById('toggle-estilos')?.checked;
    const hoja = document.getElementById('estilos-principales');
    if (hoja) hoja.disabled = !activado;
}

function cambiarValidaciones() {
    const activado = document.getElementById("toggle-validaciones")?.checked;
    const inputs = document.querySelectorAll("input");

    inputs.forEach(input => {
        if (activado) {
            input.setAttribute("required", "required");
        } else {
            input.removeAttribute("required");
        }
    });
}
