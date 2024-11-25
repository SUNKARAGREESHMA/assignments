// Bakery items
const bakeryItems = [
    { id: 1, name: "Chocolate Cake", price: 15, weight: "500g", img: "choclate cake.jpg" },
    { id: 2, name: "Croissant", price: 5, weight: "100g", img: "croissants.jpg" },
    { id: 3, name: "Fruit Pastry", price: 8, weight: "150g", img: "Fruit Pastry.jpg" }
];

// Cart array to store items added by the user
let cart = [];

// Function to display bakery items
function displayItems() {
    const itemsList = document.getElementById('items-list');
    bakeryItems.forEach(item => {
        const itemCard = document.createElement('div');
        itemCard.classList.add('item-card');
        itemCard.innerHTML = `
            <img src="${item.img}" alt="${item.name}">
            <h3>${item.name}</h3>
            <p>Price: $${item.price}</p>
            <p>Weight: ${item.weight}</p>
            <button onclick="addToCart(${item.id})">Add to Cart</button>
        `;
        itemsList.appendChild(itemCard);

        // Select the image element within the newly created item card
        const image = itemCard.querySelector('img');

        // Set a fixed width and height for the image using JavaScript
        image.style.width = '150px'; // Set a fixed width
        image.style.height = '150px'; // Set a fixed height
        image.style.objectFit = 'cover'; // Ensures the image scales properly
    });
}

// Function to add an item to the cart
function addToCart(itemId) {
    const item = bakeryItems.find(i => i.id === itemId);
    cart.push(item);
    updateCartCount();
}

// Function to update the cart count
function updateCartCount() {
    const cartCount = document.getElementById('cartCount');
    cartCount.textContent = cart.length;
}

// Function to view the cart
function viewCart() {
    const cartSection = document.getElementById('cart');
    const cartItemsList = document.getElementById('cartItems');
    cartItemsList.innerHTML = ''; // Clear previous cart items

    cart.forEach(item => {
        const listItem = document.createElement('li');
        listItem.textContent = `${item.name} - $${item.price}`;
        cartItemsList.appendChild(listItem);
    });

    cartSection.style.display = 'block';
}

// Function to close the cart
function closeCart() {
    const cartSection = document.getElementById('cart');
    cartSection.style.display = 'none';
}

// Function to checkout
function checkout() {
    alert('Thank you for your order! You will be redirected to payment.');
    cart = []; // Clear the cart after checkout
    updateCartCount();
    closeCart();
}

// Display the items when the page loads
window.onload = displayItems;
