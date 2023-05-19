const form = document.querySelector('.staff-form');
const emailInput = form.querySelector('#email');
const passwordInput = form.querySelector('#password');
const doctorSubmit = form.querySelector('[name="doctor-submit"]');
const receptionSubmit = form.querySelector('[name="reception-submit"]');
const pharmacySubmit = form.querySelector('[name="pharmacy-submit"]');

// Add submit event listener to the form
form.addEventListener('submit', function(event) {
  event.preventDefault(); // Prevent the default form submission
  
  // Validate the email and password inputs
  if (!validateEmail(emailInput.value) || !validatePassword(passwordInput.value)) {
    alert('Please enter a valid email and password.');
    return;
  }

  // Verify the user's input
  if (doctorSubmit.contains(event.target)) {
    const role = 'doctor';
    // Redirect to another page with the selected role
    window.location.href = `dashboard.html?role=${role}`;
  } else if (receptionSubmit.contains(event.target)) {
    const role = 'reception';
    // Redirect to another page with the selected role
    window.location.href = `dashboard.html?role=${role}`;
  } else if (pharmacySubmit.contains(event.target)) {
    const role = 'pharmacy';
    // Redirect to another page with the selected role
    window.location.href = `dashboard.html?role=${role}`;
  }
});

// Function to validate the email input
function validateEmail(email) {
  const regex = /\S+@\S+\.\S+/;
  return regex.test(email);
}

// Function to validate the password input
function validatePassword(password) {
  return password.length >= 8;
}
