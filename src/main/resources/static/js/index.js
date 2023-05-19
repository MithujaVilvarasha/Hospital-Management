const form = document.getElementById('form');
const firstname = document.getElementById('firstname');
const lastname = document.getElementById('lastname');
const contnum = document.getElementById('contnum');
const dob = document.getElementById('dob');
const registerdate = document.getElementById('registerdate');
const doctname = document.getElementById('doctname');
const age=document.getElementById('age');

form.addEventListener('submit', e => {
    e.preventDefault();

    validateInputs();
});

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success')
}

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};

const isValidEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

const validateInputs = () => {
    const firstnameValue = firstname.value.trim();
    const lastnameValue = lastname.value.trim();
    const contnumValue = contnum .value.trim();
    const dobValue = dob.value.trim();
     const registerdateValue = registerdate.value.trim();
     const ageValue=age.value.trim();
      const doctnameValue = doctname.value.trim();

    if(firstnameValue === '') {
        setError(firstname, 'Firstname is required');
    } else {
        setSuccess(firstname);
    }

    if(lastnameValue === '') {
        setError(lastname, 'Lastname is required');
    } 
    else {
        setSuccess(lastname);
    }

      if(contnumValue === '') {
        setError(contnum, 'contnum is required');
    } 
    else {
        setSuccess(contnum);
    }
      if(dobValue === '') {
        setError(dob, 'Dob is required');
    } 
    else {
        setSuccess(dob);
    }
    
      if(registerdateValue === '') {
        setError(registerdate, 'register date is required');
    } 
    else {
        setSuccess(registerdate);
    }
      if(ageValue === '') {
        setError(age, 'age is required');
    } 
    else {
        setSuccess(age);
    }
    
      if(doctnameValue === '') {
        setError(doctname, 'Doct Name is required');
    } 
    else {
        setSuccess(doctname);
    }

};
