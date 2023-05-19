const form = document.querySelector('form');
const nameInput = document.getElementById('name');
const emailInput = document.getElementById('email');
const telephoneInput = document.getElementById('telephone');
const messageInput = document.getElementById('message');
const checkboxInput = document.getElementById('checkbox');

form.addEventListener('submit', (event) => {
  event.preventDefault(); // Prevents form submission

  // Validation
  const nameValue = nameInput.value.trim();
  const emailValue = emailInput.value.trim();
  const telephoneValue = telephoneInput.value.trim();
  const messageValue = messageInput.value.trim();

  if (nameValue === '') {
    setErrorFor(nameInput, 'Name cannot be blank');
  } else if (!isValidName(nameValue)) {
    setErrorFor(nameInput, 'Name should only contain alphabets and spaces');
  } else {
    setSuccessFor(nameInput);
  }

  if (emailValue === '') {
    setErrorFor(emailInput, 'Email cannot be blank');
  } else if (!isValidEmail(emailValue)) {
    setErrorFor(emailInput, 'Invalid email format');
  } else {
    setSuccessFor(emailInput);
  }

  if (telephoneValue === '') {
    setErrorFor(telephoneInput, 'Telephone cannot be blank');
  } else if (!isValidTelephone(telephoneValue)) {
    setErrorFor(telephoneInput, 'Invalid telephone format');
  } else {
    setSuccessFor(telephoneInput);
  }

  if (messageValue === '') {
    setErrorFor(messageInput, 'Message cannot be blank');
  } else {
    setSuccessFor(messageInput);
  }

  if (!checkboxInput.checked) {
    setErrorFor(checkboxInput, 'Please confirm that you are not a robot');
  } else {
    setSuccessFor(checkboxInput);
  }

  // Verification
  if (
    isValidName(nameValue) &&
    isValidEmail(emailValue) &&
    isValidTelephone(telephoneValue) &&
    messageValue !== '' &&
    checkboxInput.checked
  ) {
    // Submit the form if validation and verification pass
    form.submit();
  }
});

function setErrorFor(input, message) {
  const formControl = input.parentElement;
  const errorMessage = formControl.querySelector('span');

  formControl.className = 'form-control error';
  errorMessage.innerText = message;
}

function setSuccessFor(input) {
  const formControl = input.parentElement;

  formControl.className = 'form-control success';
}

function isValidName(name) {
  return /^[a-zA-Z ]+$/.test(name);
}

function isValidEmail(email) {
  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

function isValidTelephone(telephone) {
  return /^[0-9]{10}$/.test(telephone);
}
