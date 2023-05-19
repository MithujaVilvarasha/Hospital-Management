const form = document.querySelector(form);
const doctorNameInput = document.querySelector(doctor-name);
const diseaseInput = document.querySelector(disease);
const dateInput = document.querySelector(date);
const timeInput = document.querySelector(time);
const patientNameInput = document.querySelector(patient-name);
const patientContactInput = document.querySelector(patient-contact);

form.addEventListener('submit', (e) => {
  e.preventDefault();

  // Validation
  if (doctorNameInput.value.trim() === '') {
    alert('Please enter the doctor\'s name');
    return;
  }

  if (diseaseInput.value.trim() === '') {
    alert('Please enter the disease');
    return;
  }

  if (dateInput.value.trim() === '') {
    alert('Please enter the date');
    return;
  }

  if (timeInput.value.trim() === '') {
    alert('Please enter the time');
    return;
  }

  if (patientNameInput.value.trim() === '') {
    alert('Please enter the patient\'s name');
    return;
  }

  if (patientContactInput.value.trim() === '') {
    alert('Please enter the patient\'s contact number');
    return;
  }

  if (!/^[0-9]{10}$/.test(patientContactInput.value.trim())) {
    alert('Please enter a valid 10-digit phone number');
    return;
  }

  // If validation passes
  console.log('Submitting the form...');
  form.submit("BillPayment.html");
});
