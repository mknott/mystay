<div class="modal_content">
   <div class="modal-title">My Details</div>

      <p>
              <b>Guest:</b> ${myDetails.firstName} ${myDetails.lastName}<br>
              <b>Email:</b> ${myDetails.emailAddress}<br>
              <b>Phone:</b> ${myDetails.mobileNumber}<br>
      </p>
      <p>
              <div class="modal-section">Additional Reservation Details:</div>
              <br>
              <b>Hotel Name:</b> ${myDetails.hotelName}<br>
              <b>Room #:</b> ${myDetails.roomNumber}<br>
              <b>Check-in Date:</b> ${myDetails.checkInDate}<br>
              <b>Check-out Date:</b> ${myDetails.checkOutDate}<br>
              <b>Reward Program #:</b> ${myDetails.rewardsProgramId}<br>
              <b>Confirmation Number:</b> ${myDetails.confirmationId}<br>
      </p>
      <!--
      <p>
              <b>MyStay Chats:</b> ${myDetails.myChats}
      </p>
      -->
      <p>
              <g:link url="[action:'index',controller:'newProfile']" class="cta-blue ui-link modal-close"> Update my information </g:link>
      </p>
<!--  </div>-->
</div>
