const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();

// Middleware to parse form data
app.use(bodyParser.urlencoded({ extended: true }));

// Set the views directory and set Pug as the template engine
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

// Sample users for login verification
const users = [
  { username: 'admin1', password: 'admin1' },
  { username: 'admin2', password: 'admin2' },
  { username: 'user1', password: 'user1' },
  { username: 'user2', password: 'user2' },
];

// Sample product array to store products
let products = [];

// Route to render main form
app.get('/', (req, res) => {
  res.render('loginpage'); // Renders 'loginpage.pug'
});

// Route to render login form for User login
app.get('/user-login', (req, res) => {
  res.render('login', { type: 'user' }); // Pass type as 'user' to indicate this is for user login
});

// Route to handle login form submission
app.post('/login', (req, res) => {
  const { username, password } = req.body;

  // Check if the entered username and password match any user
  const user = users.find(u => u.username === username && u.password === password);

  if (user) {
    res.render('search', { username: user.username });
  } else {
    res.render('login', { error: 'Invalid username or password' });
  }
});

// Route to render the Admin Dashboard
app.get('/admin-login', (req, res) => {
  res.render('admin-login', { products: products }); // Pass the products array to the view
});

// Route to handle product registration
app.post('/admin-login', (req, res) => {
  const { productname, productid, price, category, mfgdate, expdate } = req.body;

  // Validation logic (you can add more validation if needed)
  if (!productname || !productid || !price || !category || !mfgdate || !expdate) {
    return res.render('admin-login', { error: 'All fields are required', products: products });
  }

  // Add the new product to the products array
  const newProduct = { name: productname, productId: productid, price, category, mfgdate, expdate };
  products.push(newProduct);

  // Render the updated product list
  res.render('admin-login', { products: products });
});





// Start the server
app.listen(3000, () => {
  console.log(`Server running at port 3000`);
});




