Add-Type -AssemblyName System.Windows.Forms
Write-Host "Is it working"

# for (;;$i++)
# {
#     $POSITION = [Windows.Forms.Cursor]::Position
#     Write-Host $POSITION
# }   
for(;; $i){
$POSITION = [Windows.Forms.Cursor]::Position

$POSITION.x = 51
$POSITION.y = 81
[Windows.Forms.Cursor]::Position = $POSITION


$POSITION.x = 593
$POSITION.y = 343
[Windows.Forms.Cursor]::Position = $POSITION

}


$MYJOB = Start-Job -ScriptBlock {

    $MOVEMENTSIZE = 0
    $SLEEPTIME = 0
    
    Add-Type -AssemblyName System.Windows.Forms
   # while ($true) {
       
        Write-Host "Is it working"



     
    # $POSITION.x += $MOVEMENTSIZE
    # $POSITION.y += $MOVEMENTSIZE
    # [Windows.Forms.Cursor]::Position = $POSITION
    # Start-Sleep -Seconds $SLEEPTIME
    # $POSITION = [Windows.Forms.Cursor]::Position
    # $POSITION.x -= $MOVEMENTSIZE
    # $POSITION.y -= $MOVEMENTSIZE
    # [Windows.Forms.Cursor]::Position = $POSITION
    # Start-Sleep -Seconds $SLEEPTIME
   # }
    }