let selectedRating = 0;
const orderId = window.location.pathname.split('/').pop();

// Rating functionality
function openRatingModal() {
    document.getElementById('ratingModal').style.display = 'block';
}

function submitRating() {
    if (selectedRating === 0) {
        alert('Please select a rating');
        return;
    }

    fetch('/orders/rating', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `orderId=${orderId}&rating=${selectedRating}`
    })
    .then(response => response.text())
    .then(message => {
        alert(message);
        document.getElementById('ratingModal').style.display = 'none';
    });
}

// Star rating interaction
document.querySelectorAll('.star').forEach(star => {
    star.addEventListener('click', function() {
        selectedRating = parseInt(this.dataset.rating);
        updateStars();
    });
});

function updateStars() {
    document.querySelectorAll('.star').forEach((star, index) => {
        if (index < selectedRating) {
            star.classList.add('active');
        } else {
            star.classList.remove('active');
        }
    });
}

// Tracking functionality
function trackPackage() {
    fetch(`/orders/tracking/${orderId}`)
        .then(response => response.json())
        .then(data => {
            const baseUrl = window.location.origin;
            const trackingContent = document.getElementById('trackingContent');
            trackingContent.innerHTML = `
                <img src="${baseUrl}${data.mapImage}" alt="Tracking Map" style="width: 100%; max-width: 300px;">
                <div class="shipment-status">
                    ${data.shipments.map(shipment => `
                        <p><strong>Status:</strong> ${shipment.shipmentStatus}</p>
                        <p><strong>Tracking ID:</strong> ${shipment.shipmentTrackingId}</p>
                        <p><strong>Ship Date:</strong> ${shipment.shipmentDate}</p>
                        ${shipment.shipmentItems && shipment.shipmentItems.length > 0 ? `
                            <h4>Shipment Items</h4>
                            <ul>
                                ${shipment.shipmentItems.map(si => `
                                    <li>Order Item ID: ${si.orderItemId}, Shipped Qty: ${si.shippedQty}</li>
                                `).join('')}
                            </ul>
                        ` : ''}
                    `).join('')}
                </div>
            `;
            document.getElementById('trackingModal').style.display = 'block';
        });
}

// Download invoice
function downloadInvoice(orderId) {
    window.open(`/orders/invoice/${orderId}/download`, '_blank');
}

// Close modals
document.querySelectorAll('.close').forEach(closeBtn => {
    closeBtn.addEventListener('click', function() {
        this.closest('.modal').style.display = 'none';
    });
});

// Close modal when clicking outside
window.addEventListener('click', function(event) {
    if (event.target.classList.contains('modal')) {
        event.target.style.display = 'none';
    }
});

function reorder() {
    if (confirm('Add these items to your cart again?')) {
        // Implement reorder logic
        alert('Items added to cart!');
    }
}
