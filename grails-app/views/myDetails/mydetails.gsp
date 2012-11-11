<div class="modal_content">
        <div class="modal-title">My Details</div>

          <p>
                  <b>Guest:</b> ${myDetails.firstName} ${myDetails.lastName}<br>
          </p>
          <p>
                  <b>Hotel Name:</b> <g:cookie name="hotelName" /><br>
                  <b>Room Number:</b> ${myDetails.roomNumber}<br>
                  <b>Check-in:</b> ${myDetails.checkInDate}<br>
                  <b>Check-out:</b> ${myDetails.checkOutDate}<br>
          </p>
          <p>
                  <b>Additional Reservation Details</b><br>
                  <b>Confirmation Number:</b> ${myDetails.confirmationId}<br>
          </p>
          <p>
          </p>
          <p>
                  <b>MyStay Chats:</b> ${myDetails.myChats}
          </p>

        <a href="" class="cta-blue modal-close">close</a>
</div>
