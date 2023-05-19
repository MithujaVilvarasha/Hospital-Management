// Get the form element
const form = document.querySelector('.reception-form');

// Add an event listener for the form submission
form.addEventListener('submit', function(event) {
  // Prevent the default form submission behavior
  event.preventDefault();

  // Get the input values
  const firstName = document.getElementById('first-name').value;
  const lastName = document.getElementById('last-name').value;
  const patientId = document.getElementById('patient-id').value;
  const dob = document.getElementById('dob').value;
  const contactNumber = document.getElementById('contact-number').value;
  const doctorName = document.getElementById('doctor-name').value;

  // Validate the input values
  if (!firstName || !lastName || !dob || !contactNumber || !doctorName) {
    alert('Please fill in all fields.');
    return;
  }

  // Create an object with the input values
  const data = {
    firstName,
    lastName,
    patientId,
    dob,
    contactNumber,
    doctorName
  };

  // Encode the data as a query string and append it to the URL
  const queryString = Object.entries(data)
    .map(([key, value]) => `${encodeURIComponent(key)}=${encodeURIComponent(value)}`)
    .join('&');
  const url = `another-page.html?${queryString}`;

  // Redirect to the other page
  window.location.href = url;
});

// Retrieve form element
const patientForm = document.querySelector('.patient-form');

// Add event listener for form submission
patientForm.addEventListener('submit', (event) => {
  // Prevent default form submission behavior
  event.preventDefault();

  // Retrieve form input values
  const custodianName = document.querySelector('#custodian-name').value;
  const custodianId = document.querySelector('#custodian-id').value;
  const registeredDate = document.querySelector('#registered-date').value;
  const wardNo = document.querySelector('#ward-no').value;

  // Perform validation on form input values
  let isValid = true;

  if (custodianName.trim() === '') {
    isValid = false;
    alert('Please enter a custodian name.');
  }

  if (custodianId.trim() === '') {
    isValid = false;
    alert('Please enter a custodian ID.');
  }

  if (registeredDate.trim() === '') {
    isValid = false;
    alert('Please enter a registered date.');
  }

  if (wardNo.trim() === '') {
    isValid = false;
    alert('Please enter a ward number.');
  }

  // If input values are valid, submit form data
  if (isValid) {
    const formData = {
      custodianName,
      custodianId,
      registeredDate,
      wardNo
    };

    // POST form data to server
    fetch('/admit-patient', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formData)
    })
    .then(response => {
      if (response.ok) {
        // Redirect to new page
        window.location.href = '/success-page';
      } else {
        alert('An error occurred while submitting the form.');
      }
    })
    .catch(error => {
      alert('An error occurred while submitting the form.');
      console.error(error);
    });
  }
});

