        $(document).ready(function () {

            var seats = $('#seats').flexiSeats({
                rows: 30,
                columns: 50,
                multiple: false,
                booked: ['1-2', '4-7','13-12']
            });

            

            $('.flexiSeatsMode').click(function () {
                seats.setMultiple($(this).val());
            });

            
            $('.seat').tooltipster({
                offsetY: -10,
                theme: 'tooltipster-shadow'
            });
        });