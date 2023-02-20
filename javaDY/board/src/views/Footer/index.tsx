import IconButton from '@mui/material/IconButton'
import Typography from '@mui/material/Typography'
import { Box } from '@mui/system'
import React from 'react'
import InstagramIcon from '@mui/icons-material/Instagram';
import FacebookIcon from '@mui/icons-material/Facebook';

export default function Footer() {
  return (
    <Box sx={{p: '40px 120px 50px 120px', backgroundColor: '#373737'}}>
        <Box sx={{ display: 'flex', justifyContent:'space-between'}}>
            <Box>
                <Typography sx={{fontSize: '20px', fontWeight: 400, color:'#ffffff'}}>Hoons Board</Typography>
            </Box>

            <Box>
                <Typography component='span' sx={{fontSize:'12px', fontWeight: 400, color: '#ffffff'}}>HoonsBoard@gmail.com</Typography>
                <IconButton>
                    <InstagramIcon sx={{color : '#ffffff'}}/>
                </IconButton>
                <IconButton>
                    <FacebookIcon sx={{color: '#ffffff'}}/>
                </IconButton>
            </Box>
        </Box>
        <Typography sx={{fontSize:'12px', fontWeight: 400, color: '#ffffff'}}>Copyright @ 2022 jukoyakki. All Rights Reserved</Typography>
    </Box>
  )
}
